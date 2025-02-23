import java.util.*;
import java.util.regex.*;

public class AIChatbot {
    private static final Map<String, String> responses = new HashMap<>();

    // Initialize predefined responses
    static {
        responses.put("hi", "Hello! How can I assist you today?");
        responses.put("hello", "Hi there! What can I do for you?");
        responses.put("how are you", "I'm just a chatbot, but I'm here to help!");
        responses.put("what is your name", "I'm AI Chatbot, your virtual assistant.");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("default", "I'm not sure how to respond to that. Can you rephrase?");
    }

    public static String getResponse(String userInput) {
        userInput = userInput.toLowerCase().trim();
        for (String key : responses.keySet()) {
            if (Pattern.compile("\\b" + key + "\\b").matcher(userInput).find()) {
                return responses.get(key);
            }
        }
        return responses.get("default");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("AI Chatbot: Hello! Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String userMessage = scanner.nextLine();

            if (userMessage.equalsIgnoreCase("bye")) {
                System.out.println("AI Chatbot: " + responses.get("bye"));
                break;
            }

            String botResponse = getResponse(userMessage);
            System.out.println("AI Chatbot: " + botResponse);
        }
        
        scanner.close();
    }
}
