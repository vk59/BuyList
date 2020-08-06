package com.vk59.buylist.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.vk59.buylist.R;
import com.vk59.buylist.adapters.ProductsListAdapter;
import com.vk59.buylist.models.Product;
import com.vk59.buylist.view_models.ProductsListViewModel;

import java.util.List;

public class ProductsListActivity extends AppCompatActivity {
    private ProductsListAdapter adapter;
    private ProductsListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        setTitle(R.string.pruducts_list_activity_title);

        adapter = new ProductsListAdapter(this);
        ListView listView = findViewById(R.id.productsList);
        listView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()))
                .get(ProductsListViewModel.class);

        viewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> product) {
                adapter.refresh(product);
            }
        });

        SearchView searchView = findViewById(R.id.productsSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    public void onAddClick(View view) {
        final EditText editText = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle(R.string.adding_product)
                .setMessage(R.string.write_name)
                .setView(editText)
                .setNegativeButton(R.string.cansel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton(R.string.ready, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editText.getText().toString();
                        if (!"".equals(name)) {
                            viewModel.createProduct(name);
                            dialog.dismiss();
                        }

                    }
                }).create().show();
    }
}