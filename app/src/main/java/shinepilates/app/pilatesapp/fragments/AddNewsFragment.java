package shinepilates.app.pilatesapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.objects.NewsItem;

public class AddNewsFragment extends Fragment {
    EditText addTag;
    EditText addText;
    Button addNews;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_news, container, false);
        addTag = root.findViewById(R.id.addNewsTheme);
        addText = root.findViewById(R.id.addNews);
        addNews = root.findViewById(R.id.addNew);
        addNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = String.valueOf(addTag.getText());
                String Text2 = String.valueOf(addText.getText());
                NewsItem news = new NewsItem();
                news.setMainText(Text2);
                news.setTag(Text);
                long epoch = System.currentTimeMillis() / 1000;
                String date = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(epoch * 1000));
                news.setDate(date);
                MainActivity.getInstance().addNew(news);
            }
        });
        return root;
    }
}
