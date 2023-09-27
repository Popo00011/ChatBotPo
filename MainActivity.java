import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout chatContainer;
    private EditText userInput;
    private Button sendButton;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatContainer = findViewById(R.id.chatContainer);
        userInput = findViewById(R.id.userInput);
        sendButton = findViewById(R.id.sendButton);
        scrollView = findViewById(R.id.scrollView);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String userMessage = userInput.getText().toString().trim();
        if (!userMessage.isEmpty()) {
            addMessage("You: " + userMessage);
            // Process user message and generate a bot response here
            // For simplicity, let's assume a rule-based response
            String botResponse = getBotResponse(userMessage);
            addMessage("Bot: " + botResponse);
            userInput.getText().clear();
            scrollToBottom();
        }
    }

    private void addMessage(String message) {
        TextView textView = new TextView(this);
        textView.setText(message);
        chatContainer.addView(textView);
    }

    private void scrollToBottom() {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    // Simulated rule-based chatbot response
    private String getBotResponse(String userMessage) {
        if (userMessage.contains("hello")) {
            return "Hello!";
        } else if (userMessage.contains("how are you")) {
            return "I'm just a chatbot, but I'm doing well. How can I assist you?";
        } else if (userMessage.contains("bye")) {
            return "Goodbye! Feel free to return if you have more questions.";
        } else {
            return "I'm sorry, I don't understand that.";
        }
    }
}
