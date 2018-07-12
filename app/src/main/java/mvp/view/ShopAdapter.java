package mvp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liqy.searchapp.R;

import java.util.ArrayList;
import java.util.List;

import mvp.model.Shop;

/**
 * @file FileName
 * SearchApp
 *  * liqy
 * Copyright 星期四 YourCompany.
 */
public class ShopAdapter extends BaseAdapter {

    List<Shop> list;
    Context context;

    public ShopAdapter(Context context) {
        this.context=context;
        list=new ArrayList<>();
    }

    /**
     * 增加数据到列表
     * @param shops
     */
    public void addData(List<Shop> shops){
        this.list.addAll(shops);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Shop getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_shop, viewGroup, false);
            holder.title = (TextView) view.findViewById(R.id.txt_shop_title);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Shop shop=getItem(i);
        holder.title.setText(shop.name);
        return view;
    }

    static class ViewHolder {


        TextView title;

    }
}
