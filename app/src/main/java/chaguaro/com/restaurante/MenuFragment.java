package chaguaro.com.restaurante;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Item> listaItems;

    private OnFragmentInteractionListener mListener;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.menu_layout, null);

        /*
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.title_main);
        */

        ListView listView=(ListView) view.findViewById(R.id.lst_items);
        listView.setAdapter(new ItemAdapter(getActivity(), listaItems));
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    */

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void cargaItems (int tipoMenu) {
        listaItems=new ArrayList<Item>();

        if (tipoMenu==MainActivity.MEDICAMENTOS) {

            listaItems.add(new Item("Aspirina", "Analgesico para el dolor de cabeza", "5,43"));
            listaItems.add(new Item("Ibuprofeno", "Analgesico general", "2.56"));
            listaItems.add(new Item("Voltaren", "Analgesico topico focalizado", "1.12"));
            listaItems.add(new Item("Tempra", "Antifebril", "3.21"));
            listaItems.add(new Item("Finalin", "Analgesico", "1.67"));
            listaItems.add(new Item("Migradorixina", "Analgesico", "5.12"));
            listaItems.add(new Item("Buprex", "Analgesico y Antifebril", "2.34"));
            listaItems.add(new Item("Alercet", "Antiestaminico, ", "5.43"));

        } else if (tipoMenu==MainActivity.SUPLEMENTOS) {

            listaItems.add(new Item("Cerelac", "Envase metalico 500 g", "4.30"));
            listaItems.add(new Item("Proteina hidrolizada", "Envase plastico 12 Kg", "12.98"));
            listaItems.add(new Item("Colageno", "Capsulas blandas", "4.55"));
            listaItems.add(new Item("Redbull", "Energizante importado 500 ml", "2.50"));
            listaItems.add(new Item("V220", "Energizante 330 ml", "1.25"));

        } else if (tipoMenu==MainActivity.HOGAR) {

            listaItems.add(new Item("Shampoo coco", "Sin sal ni parafenos, hidratante", "3.66"));
            listaItems.add(new Item("Cepillo dental", "cerdas suaves, 3 unidades", "2.12"));
            listaItems.add(new Item("Pasta dental", "Colgate blanqueador, maxima proteccion", "3.21"));
            listaItems.add(new Item("Afeitadora", "Paquete de 3 unidades marca shift", "3.00"));
            listaItems.add(new Item("Velas", "blancas sin aroma, paquete de 10 unidades", "1.00"));
            listaItems.add(new Item("Vaporup", "caja plastica", "0.90"));
            listaItems.add(new Item("Mentol chino", "caja metalica, 20 g", "0.86"));

        } else if (tipoMenu==MainActivity.NATURISTAS) {

            listaItems.add(new Item("Aceite escencial Pino", "Aceite 100% puro, sin quimicos ni diluyentes", "12.34"));
            listaItems.add(new Item("Aceite escencial Lavanda", "Aceite 100% puro, sin quimicos ni diluyentes", "13.25"));
            listaItems.add(new Item("Aceite escencial Menta", "Aceite 100% puro, sin quimicos ni diluyentes", "11.00"));
            listaItems.add(new Item("Incienso hindu", "Caja de 10 unidades", "8.00"));
            listaItems.add(new Item("Caja te Manzanilla", "Caja de 40 unidades", "1.25"));
            listaItems.add(new Item("Caja te Cedron", "Caja de 25 unidades", "1.25"));
            listaItems.add(new Item("Caja te Oregano", "Caja de 25 unidades", "1.25"));

        }
    }
}
