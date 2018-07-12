package mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.liqy.searchapp.R;

import mvp.model.RootData;
import mvp.presenter.ShopPresenter;

public class ShopListActivity extends AppCompatActivity implements IShopView{

    ShopPresenter presenter;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        listView=(ListView)findViewById(R.id.listView);
        presenter=new ShopPresenter(this);
        presenter.getList();
    }

    @Override
    public void showData(RootData data) {
        ShopAdapter adapter=new ShopAdapter(this);
        adapter.addData(data.data);
        listView.setAdapter(adapter);
    }
}


