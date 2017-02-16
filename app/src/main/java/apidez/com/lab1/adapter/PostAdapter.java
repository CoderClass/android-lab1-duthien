package apidez.com.lab1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import apidez.com.lab1.R;
import apidez.com.lab1.model.Post;

/**
 * Created by nongdenchet on 10/9/16.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    private List<Post> mPosts;
    Context context;

    public PostAdapter(Context context, List<Post> posts) {
        super(context, -1);
        mPosts = posts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
            viewHolder  = new ViewHolder();
            viewHolder.ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            viewHolder.tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.tvUsername.setText(mPosts.get(position).getUsername());
        loadImage(viewHolder.ivImage, mPosts.get(position).getAvatar());
        viewHolder.tvDate.setText(mPosts.get(position).getDate());
        viewHolder.tvDescription.setText(mPosts.get(position).getDescription());
        loadImage(viewHolder.ivImage , mPosts.get(position).getImage());

        return convertView;
    }

    private void loadImage(ImageView imageView, String path) {
        Picasso.with(getContext())
                .load(path)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }

    public class ViewHolder {
        public TextView tvUsername;
        public TextView tvDescription;
        public TextView tvDate;
        public ImageView ivAvatar;
        public ImageView ivImage;
    }
}
