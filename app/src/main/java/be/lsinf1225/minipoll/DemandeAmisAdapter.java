package be.lsinf1225.minipoll;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import be.lsinf1225.minipoll.model.User;


/**
 * Created by jerome on 09/02/17.
 */
public class DemandeAmisAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<User> amis;


    public DemandeAmisAdapter(Context c, ArrayList<User> amis) {
        this.context = c;
        this.amis = amis;
        this.context =c;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_ami;
        public ImageView im_ami;
        public Button btn_accept;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_ami = (TextView) itemView.findViewById(R.id.nom_ami);
            im_ami = (ImageView) itemView.findViewById(R.id.photo_ami);
            btn_accept = (Button) itemView.findViewById(R.id.btn_accept);
        }
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_amis_demande, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_ami.setText(amis.get(position).getNom());
        myViewHolder.btn_accept.setOnClickListener(acceptClickListener);
        try{
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), Uri.parse(MiniPoll.getConnected_user().getImagePath()));
            myViewHolder.im_ami.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
            myViewHolder.im_ami.setImageResource(R.drawable.friends);
        }
    }


    @Override
    public int getItemCount() {
        Log.i("DEBUG_J", "adapter"+String.valueOf(amis.size()));
        return amis.size();
    }

    View.OnClickListener acceptClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

}