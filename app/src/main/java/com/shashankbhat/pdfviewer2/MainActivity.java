package com.shashankbhat.pdfviewer2;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.multi.SnackbarOnAnyDeniedMultiplePermissionsListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class MainActivity extends AppCompatActivity implements DownloadFile.Listener{

    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    @BindView(R.id.pdfViewPager)
    PDFViewPager pdfViewPager;

    @BindView(R.id.show_pdf)
    Button showPdfButton;

    @BindView(R.id.url_edit_text)
    EditText url_edit_text;

    private RemotePDFViewPager remotePDFViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        requestPermission();

        url_edit_text.setText("http://hortonworks.com/wp-content/uploads/2016/05/Hortonworks.CheatSheet.SQLtoHive.pdf");

        showPdfButton.setOnClickListener(view -> {
            String url = url_edit_text.getText().toString();
            if (!url.isEmpty())
                remotePDFViewPager =
                        new RemotePDFViewPager(this, url, this);
            else
                Toast.makeText(getApplicationContext(), "Empty URL", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onSuccess(String url, String destinationPath) {

        PDFPagerAdapter adapter = new PDFPagerAdapter(this, destinationPath);
        remotePDFViewPager.setAdapter(adapter);
        setContentView(remotePDFViewPager);
    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    private void requestPermission() {

        MultiplePermissionsListener snackbarMultiplePermissionsListener =
                SnackbarOnAnyDeniedMultiplePermissionsListener.Builder
                        .with(linearLayout, "Write to External Storage is needed to download the PDF and store it")
                        .withOpenSettingsButton("Settings")
                        .build();

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(snackbarMultiplePermissionsListener).check();
    }

}
