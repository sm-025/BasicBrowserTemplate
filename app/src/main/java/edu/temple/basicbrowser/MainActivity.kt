package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var urlEditText: EditText
    private lateinit var goButton: ImageButton
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        goButton.setOnClickListener{
            var enteredURL = urlEditText.text

            if (!enteredURL.startsWith("https://")) {
                Log.d("urlcheck:", enteredURL.toString())
                var processedURL = StringBuilder()
                processedURL.append("https://")
                processedURL.append(enteredURL)
                Log.d("checking: ", processedURL.toString())

                webView.loadUrl(processedURL.toString())
            }
        }

    }
}