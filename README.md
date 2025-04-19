# Trello API Test Projesi

Bu proje, Trello API'sini test etmek için Rest Assured kullanılarak geliştirilmiş bir test otomasyonu projesidir.

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

## Kurulum

1. Projeyi klonlayın
2. Maven bağımlılıklarını yükleyin: `mvn clean install`
3. Testleri çalıştırın: `mvn test`

## API Bilgileri

- Base URL: https://api.trello.com/1
- Board ID, API Key ve Token bilgileri config sınıfında tanımlanmıştır.
