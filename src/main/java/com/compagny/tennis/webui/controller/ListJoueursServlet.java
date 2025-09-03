package com.compagny.tennis.webui.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.example.tennis.EntityManagerHolder;
import org.example.tennis.dto.JoueursDto;
import org.example.tennis.entity.Joueur;
import org.example.tennis.services.JoueursServices;

public class ListJoueursServlet extends HttpServlet {

    private JoueursServices joueursServices;

    public ListJoueursServlet() {
        this.joueursServices = new JoueursServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, List<Joueur>> allJoueurs = EntityManagerHolder.getAll();

        req.setAttribute("listeHommes", allJoueurs.get("hommes"));
        req.setAttribute("listeFemmes", allJoueurs.get("femmes"));

        RequestDispatcher disp = req.getRequestDispatcher("liste.jsp");
        disp.forward(req, resp);
    }


}
