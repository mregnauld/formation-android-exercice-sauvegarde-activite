package com.formationandroid.sauvegardeactivite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
	
	// Constantes :
	private static final int VALEUR_DE_MIN = 1;
	private static final int VALEUR_DE_MAX = 6;
	private static final String VALEUR_DE_1 = "VALEUR_DE_1";
	private static final String VALEUR_DE_2 = "VALEUR_DE_2";
	private static final String VALEUR_DE_3 = "VALEUR_DE_3";
	private static final String VALEUR_RESET = "VALEUR_RESET";
	
	// Valeurs des dés :
	private int valeurDe1 = 0;
	private int valeurDe2 = 0;
	private int valeurDe3 = 0;
	private boolean reset = false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// reset :
		if (savedInstanceState != null)
		{
			reset = savedInstanceState.getBoolean(VALEUR_RESET);
			reset = !reset;
		}
		
		// valeurs aléatoires :
		if (savedInstanceState == null || reset)
		{
			// initialisation si première exécution :
			valeurDe1 = new Random().nextInt(VALEUR_DE_MAX) + VALEUR_DE_MIN;
			valeurDe2 = new Random().nextInt(VALEUR_DE_MAX) + VALEUR_DE_MIN;
			valeurDe3 = new Random().nextInt(VALEUR_DE_MAX) + VALEUR_DE_MIN;
			reset = true;
		}
		else
		{
			// récupération des valeurs sauvegardées :
			valeurDe1 = savedInstanceState.getInt(VALEUR_DE_1);
			valeurDe2 = savedInstanceState.getInt(VALEUR_DE_2);
			valeurDe3 = savedInstanceState.getInt(VALEUR_DE_3);
		}
		
		// vues :
		TextView textViewDe1 = findViewById(R.id.de_1);
		TextView textViewDe2 = findViewById(R.id.de_2);
		TextView textViewDe3 = findViewById(R.id.de_3);
		
		// affichage :
		textViewDe1.setText(String.valueOf(valeurDe1));
		textViewDe2.setText(String.valueOf(valeurDe2));
		textViewDe3.setText(String.valueOf(valeurDe3));
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		// appel obligatoire :
		super.onSaveInstanceState(outState);
		
		// sauvegarde :
		outState.putInt(VALEUR_DE_1, valeurDe1);
		outState.putInt(VALEUR_DE_2, valeurDe2);
		outState.putInt(VALEUR_DE_3, valeurDe3);
		outState.putBoolean(VALEUR_RESET, reset);
	}
	
}
