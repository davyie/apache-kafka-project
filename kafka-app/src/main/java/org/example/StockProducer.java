package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class StockProducer {
    private ObjectMapper mapper = new ObjectMapper();
    private String url = "http://api.marketstack.com/v1/eod?access_key=c3966ee313396256b969d0e28ff854a0&symbols=TSLA&date_from=2023-09-11&date_to=2023-09-21";
    public StockProducer() throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(props);

        HttpGet request = new HttpGet(url);

        try(CloseableHttpClient client = HttpClients.createDefault()) {
            client.execute(request, httpResponse -> {
                JsonNode node = mapper.readTree(EntityUtils.toString(httpResponse.getEntity()));
                int i = 0;
                for (JsonNode element : node.get("data")) {
                    kafkaProducer.send(new ProducerRecord("tesla", String.valueOf(i), element.toString()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                kafkaProducer.flush();
                kafkaProducer.close();
                return null;
            });
        }
    }
}
