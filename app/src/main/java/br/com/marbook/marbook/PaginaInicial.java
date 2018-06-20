package br.com.marbook.marbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class PaginaInicial extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        RecyclerView recyclerView;

        ArrayList<ModelLivro> livrosList;
        Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);
        button = (Button) findViewById(R.id.btcad);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final Intent abreReserva = new Intent(PaginaInicial.this, Reserva.class);
                startActivity(abreReserva);
            }});
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = findViewById(R.id.rv);

        livrosList = new ArrayList<>();

        livrosList.add(new ModelLivro(R.drawable.img1, "Retrato Falado", "Editora GLOBO - Autor(a): Denise Fraga", "R$ 8,50"));
        livrosList.add(new ModelLivro(R.drawable.img2,"Marilia de Dirceu", "Literatura Brasileira | Arcadismo  - Autor(a): Tomás Antonio Gonzaga", "R$ 5,00"));
        livrosList.add(new ModelLivro(R.drawable.img3,"Macunaíma", "Literatura Brasileira | Modernismo - Autor(a): Mário de Andrade", "R$ 5,00"));
        livrosList.add(new ModelLivro(R.drawable.img4,"O amanuense Belmiro", "Editora GLOBO - Autor(a): Cyro dos Anjos", "R$ 8,00"));
        livrosList.add(new ModelLivro(R.drawable.img5,"Química", "Ensino médio, Volume: 1, Editora: RSE - Autor(a): Nelson Orlando Beltran", "Grátis"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);

        LivroAdapter adapter = new LivroAdapter(this, livrosList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pagina_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ic_col){
            /* Handle the camera action */
        }else if (id == R.id.ic_book) {

        } else if (id == R.id.ic_cont) {

        } else if (id == R.id.ic_info) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

