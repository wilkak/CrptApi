package org.example;

import java.util.concurrent.TimeUnit;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CrptApi api = new CrptApi(TimeUnit.MINUTES, 10);
        CrptApi.Document.Description description = new CrptApi.Document.Description();
        description.setParticipantInn("123456789");

        CrptApi.Document.Product product = new CrptApi.Document.Product();
        product.setCertificate_document("cert_doc");
        product.setCertificate_document_date("2023-06-30");
        product.setCertificate_document_number("12345");
        product.setOwner_inn("owner_inn");
        product.setProducer_inn("producer_inn");
        product.setProduction_date("2023-06-30");
        product.setTnved_code("code");
        product.setUit_code("uit_code");
        product.setUitu_code("uitu_code");

        CrptApi.Document document = new CrptApi.Document();
        document.setDescription(description);
        document.setDoc_id("doc_id");
        document.setDoc_status("status");
        document.setImportRequest(true);
        document.setOwner_inn("owner_inn");
        document.setParticipant_inn("participant_inn");
        document.setProducer_inn("producer_inn");
        document.setProduction_date("2023-06-30");
        document.setProduction_type("type");
        document.setProducts(new CrptApi.Document.Product[]{product});
        document.setReg_date("2023-06-30");
        document.setReg_number("reg_number");

        try {
            api.createDocument(document, "signature");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
