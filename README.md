# Trello API Test Projesi

Bu proje, Trello API'sini test etmek için oluşturulmuş bir test otomasyonu projesidir.

## Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/damragencc/apiTrello.git
cd apiTrello
```

2. Trello API Bilgilerini Ayarlama:
   - [Trello Developer Portal](https://trello.com/app-key)'a gidin
   - API Key ve Token bilgilerinizi alın
   - `src/test/resources/config.properties.example` dosyasını `config.properties` olarak kopyalayın:
   ```bash
   cp src/test/resources/config.properties.example src/test/resources/config.properties
   ```
   - `config.properties` dosyasını açın ve kendi API bilgilerinizi ekleyin:
   ```properties
   trello.api.key=your_api_key_here
   trello.api.token=your_token_here
   ```

3. Maven bağımlılıklarını yükleyin:
```bash
mvn clean install -DskipTests
```

## Testleri Çalıştırma

Tüm testleri çalıştırmak için:
```bash
mvn test
```

Ya da IntelliJ IDEA'da:
1. `src/test/java/tests/BoardTest.java` dosyasını açın
2. Class seviyesinde yeşil "play" butonuna tıklayın

## Test Kapsamı

Proje aşağıdaki Trello API işlemlerini test eder:
- Board oluşturma ve silme
- Board güncelleme
- Liste oluşturma
- Etiket oluşturma
- Üye yönetimi
- ve daha fazlası...

## Önemli Notlar

- API bilgilerinizi güvenli tutun, `config.properties` dosyası .gitignore'da olduğu için GitHub'a gönderilmeyecektir
- Her test çalıştırmasından sonra oluşturulan test board'ları otomatik olarak silinir
- Testler paralel çalışacak şekilde tasarlanmıştır

## Katkıda Bulunma

1. Bu repository'yi fork edin
2. Feature branch'i oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add some amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

## Teknolojiler

- Java 11
- Maven
- Rest Assured
- TestNG
- Jackson

## Proje Yapısı

- `config`: Konfigürasyon sınıfları
- `services`: API istekleri için servis sınıfları
- `tests`: Test sınıfları

## API Bilgileri

- Base URL: https://api.trello.com/1
- Board ID, API Key ve Token bilgileri config sınıfında tanımlanmıştır.
