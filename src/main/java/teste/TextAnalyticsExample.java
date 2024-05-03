package teste;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.ai.textanalytics.models.SentenceSentiment;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Context;

public class TextAnalyticsExample {
    public static void main(String[] args) {
        // Chave de autenticação e endpoint do serviço de Análise de Texto do Azure
        String key = "<sua-chave>";
        String endpoint = "<seu-endpoint>";

        // Crie um cliente para o serviço de Análise de Texto do Azure
        TextAnalyticsClientBuilder clientBuilder = new TextAnalyticsClientBuilder();
        clientBuilder.credential(new AzureKeyCredential(key));
        clientBuilder.endpoint(endpoint);
        com.azure.ai.textanalytics.TextAnalyticsClient textAnalyticsClient = clientBuilder.buildClient();

        // Texto para análise de sentimento
        String document = "Eu amo o Azure Cognitive Services!";

        // Realize a análise de sentimento do documento
        DocumentSentiment documentSentiment = textAnalyticsClient.analyzeSentiment(document, "en");

        // Exiba o sentimento geral do documento
        System.out.printf("Sentimento geral do documento: %s%n", documentSentiment.getSentiment());

        // Exiba o sentimento de cada frase no documento
        for (SentenceSentiment sentenceSentiment : documentSentiment.getSentences()) {
            System.out.printf("Sentimento da frase: %s%n", sentenceSentiment.getSentiment());
        }
    }
}
