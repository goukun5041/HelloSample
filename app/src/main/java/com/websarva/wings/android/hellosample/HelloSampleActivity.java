package com.websarva.wings.android.hellosample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.websarva.wings.android.hellosample.R.id.btClick;

public class HelloSampleActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_sample);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        //表示ボタンであるButtonオブジェクト取得
        Button btClick = (Button)findViewById(R.id.btClick);
        //リスなクラスのインスタンスを生成
        HelloListener listener = new HelloListener();
        //表示ボタンにリスナを設定
        btClick.setOnClickListener(listener);

        //クリアボタンであるButtonpブジェクト取得
        Button btclear = (Button) findViewById(R.id.btClear);
        //クリアボタンにリスナ設定
        btclear.setOnClickListener(listener);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("HelloSample Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    /**
     * ボタンをクリックした時のリスなクラス
     */
    private class HelloListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //名前入力欄であるEditTextオブジェクト取得
            EditText input = (EditText)findViewById(R.id.etName);
            //メッセージを表示するTwxtViewオブジェクト取得
            TextView output = (TextView)findViewById(R.id.tvOutput);

            //タップされた画面部品のidのR値を取得
            int id = view.getId();
            //idのR値に応じて処理分岐
            switch (id) {
                //表示ボタンの場合
                case R.id.btClick:
                    //入力されたら名前文字列を取得
                    String inputStr = input.getText().toString();
                    //メッセージを表示
                    output.setText(inputStr + "さん、こんにちは！");
                    break;
                //クリアボタンの場合
                case R.id.btClear:
                    //名前入力欄を空白にする
                    input.setText("");
                    //メッセージ欄を空白にする
                    output.setText("");
                    break;
            }
        }
    }
}