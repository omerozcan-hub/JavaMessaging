## Socket Programming 

- Bu yöntemin mantığı şudur; ServerAdres üzerinde (ben localhost kullandım) portlar ile serverSocket'ler açarak bu socketler vasıtasıyla iletişim oluşturmak.
- client modülünden hem mesaj hem dosya gönderiyorum. server modülünde bu serversocket'ler dinleniyor ve gelen dosya kaydediliyor, gelen mesaj ise console'a basılıyor.

#### Socket programming diagram
![sp](assets/maxresdefault.jpg)


#### Log
client\
![client](assets/Ekran%20görüntüsü%202024-10-18%20114442.png)

server\
![server](assets/Ekran%20görüntüsü%202024-10-18%20114452.png)