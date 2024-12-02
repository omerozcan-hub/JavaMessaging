## ZeroMQ

Bu proje, **ZeroMQ** kullanılarak oluşturulmuş bir sipariş işleme sisteminin basit bir örneğidir. Sistem, mikroservis benzeri bir yapıya sahiptir ve üç farklı servis içerir:

1. **Order Service**: Sipariş oluşturur ve stok kontrolü için mesaj gönderir.
2. **Inventory Service**: Stok kontrolünü yapar ve sipariş durumunu bildirir.
3. **Notification Service**: Müşteriye sipariş durumu hakkında bildirim gönderir.

---

## **Proje Mimarisi**

Servisler arasında iletişim için **ZeroMQ** kullanılmıştır. İletişim modeli şöyledir:

1. **Order Service** bir sipariş oluşturur ve bunu **Inventory Service**'e iletir (**PUSH-PULL** modeli).
2. **Inventory Service** siparişi işler ve sonucunu **Notification Service**'e gönderir (**PUSH-PULL** modeli).
3. **Notification Service** gelen mesajı alır ve bir bildirim olarak simüle eder.

---

## **Bağımlılıklar**

Projeyi çalıştırmadan önce aşağıdaki bağımlılığı `pom.xml` dosyanıza eklediğinizden emin olun:

```xml
<dependency>
  <groupId>org.zeromq</groupId>
  <artifactId>jeromq</artifactId>
  <version>0.6.0</version>
</dependency>
```

---
## Çalışma Mantığı
1. Order Service, tcp://*:5555 adresine sipariş gönderir.
2. Inventory Service, tcp://localhost:5555 adresinden siparişi alır, işler ve sonucu tcp://*:5556 adresine gönderir.
3. Notification Service, tcp://localhost:5556 adresinden sonucu alır ve bildirir.
---
#### Log
![order](assets/Ekran%20görüntüsü%202024-12-02%20141827.png)
![inventory](assets/Ekran%20görüntüsü%202024-12-02%20141810.png)
![notification](assets/Ekran%20görüntüsü%202024-12-02%20141815.png)
