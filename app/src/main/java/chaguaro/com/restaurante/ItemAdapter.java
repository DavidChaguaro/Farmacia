package chaguaro.com.restaurante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Luis Rocha on 17/1/2019.
 */

public class ItemAdapter extends BaseAdapter {

    Context context;
    List<Item> listaItems;

    public ItemAdapter (Context context, List<Item> listaItems) {
        this.context=context;
        this.listaItems=listaItems;
    }

    @Override
    public int getCount() {
        return listaItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listaItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.menu_plato_layout, parent, false);
        }

        Item item=(Item)getItem(position);

        TextView titulo=(TextView) convertView.findViewById(R.id.txt_item_titulo);
        TextView descripcion=(TextView) convertView.findViewById(R.id.txt_item_descripcion);
        TextView precio=(TextView) convertView.findViewById(R.id.txt_item_precio);

        titulo.setText(item.getTitulo());
        descripcion.setText(item.getDescripcion());
        precio.setText(item.getPrecio());

        return convertView;
    }
}
