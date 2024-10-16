## Java Message Service (JMS)

JMS api kuralları ve activemq (broker) sağlayıcısı ile çok basit bir iletişim yöntemi oluşturuyoruz.

- İlk olarak activemq'u makinenizde çalıştırmalısın. Ben docker aracılığı ile bunu sağladım. \
-> ``` docker pull apache/activemq-classic``` \
-> ``` docker run -d --name activermq-container -p 61616:61616 -p 8161:8161 apache/activemq-classic:latest ```

- Projenin .properties kısmında activemq configürasyonlarını tanımlamalıyız. \
``` text 
    spring.activemq.broker-url=tcp://localhost:61616 
    spring.activemq.user=admin 
    spring.activemq.password=admin 
``` 
- JmsTemplate Instans'ı ile "destination ve message" içerği tanımlayarak message gönderebiliriz. [kod içeriği](producer/src/main/java/com/example/producer/JmsProducer.java)
- @JmsListener(destination = "...") anotasyonu ile de ilgili destination'ı dinleyerek messajları alırız. [kod içeriği](consumer/src/main/java/com/example/consumer/JmsConsumer.java)

#### Log
![producer](assets/Ekran%20görüntüsü%202024-10-16%20124218.png)
![consumer](assets/Ekran%20görüntüsü%202024-10-16%20124224.png)