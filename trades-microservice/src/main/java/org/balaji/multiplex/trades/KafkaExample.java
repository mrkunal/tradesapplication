package org.balaji.multiplex.trades;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

public class KafkaExample {
    private final String topic;
    private final Properties props;

    public KafkaExample(String brokers, String username, String password) {
        this.topic = username + "-default";

        String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
        String jaasCfg = String.format(jaasTemplate, username, password);

        String serializer = StringSerializer.class.getName();
        String deserializer = StringDeserializer.class.getName();
        props = new Properties();
        props.put("bootstrap.servers", brokers);
        props.put("group.id", username + "-consumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", deserializer);
        props.put("value.deserializer", deserializer);
        props.put("key.serializer", serializer);
        props.put("value.serializer", serializer);
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        props.put("sasl.jaas.config", jaasCfg);
    }

    public void consume() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topic));
        int i=0;
        while (i<10) {
            ConsumerRecords<String, String> records = consumer.poll(4000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("%s [%d] offset=%d, key=%s, value=\"%s\"\n",
                        record.topic(), record.partition(),
                        record.offset(), record.key(), record.value());
            }
            i++;
        }
    }

    public void produce() {
        Thread one = new Thread() {
            public void run() {
                try {
                    Producer<String, String> producer = new KafkaProducer<>(props);
                    int i = 0;
                    while(i<10) {
                        Date d = new Date();
                        Header header=new Header() {
                            @Override
                            public String key() {
                                return "MyCustom";
                            }

                            @Override
                            public byte[] value() {
                                return new byte[0];
                            }
                        };
                        List<Header> headers=new ArrayList<>();
                        headers.add(header);

                        producer.send(new ProducerRecord<>(topic,0, Integer.toString(i), d.toString(),headers));
                        Thread.sleep(5000);
                        i++;
                    }
                } catch (InterruptedException v) {
                    System.out.println(v);
                }
            }
        };
        one.start();
    }

    public static void main(String[] args) {
//        String brokers = System.getenv("CLOUDKARAFKA_BROKERS");
        String brokers = "tricycle-01.srvs.cloudkafka.com:9094";
//        String username = System.getenv("CLOUDKARAFKA_USERNAME");
        String username = "xbafbes6";
//        String password = System.getenv("CLOUDKARAFKA_PASSWORD");
        String password = "CzuQH8VTPLZ4tZB8kJAg-su47-agzAhq";
        KafkaExample c = new KafkaExample(brokers, username, password);
        c.produce();
        c.consume();
    }
}
