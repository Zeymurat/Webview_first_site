package arsivmedya.webviewdeneme;

        import android.app.Activity;
        import android.app.ProgressDialog;
        import android.os.Bundle;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.Toast;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Bu metod uygulama açıldığında çalıştırılan metod.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // webView'i tasarımdakiyle bağlıyoruz.
        webView = (WebView) findViewById(R.id.webview1);

        // webView'i JavaScript kodlarını çalıştıracak şekilde set ediyoruz.
        webView.getSettings().setJavaScriptEnabled(true);

        // Sayfanın yüklendiğinin anlaşılması için ProgressDialog açıyoruz.
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Arsiv Medya",
                "Sayfa Yükleniyor...", true);

        webView.setWebViewClient(new WebViewClient() {

            // Sayfa Yüklenirken bir hata oluşursa kullanıcıyı uyarıyoruz.
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Sayfa Yüklenemedi!",
                        Toast.LENGTH_SHORT).show();
            }

            // Sayfanın yüklenme işlemi bittiğinde progressDialog'u kapatıyoruz.
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });

        //Web sayfamızın url'ini webView'e yüklüyoruz.
        webView.loadUrl("https://bitkiselgida.com/");

    }
}