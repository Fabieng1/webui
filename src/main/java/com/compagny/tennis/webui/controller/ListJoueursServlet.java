package com.compagny.tennis.webui.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.example.tennis.dto.JoueursDto;
import org.example.tennis.services.JoueursServices;

public class ListJoueursServlet extends HttpServlet {

    private JoueursServices joueursServices;

    public ListJoueursServlet() {
        this.joueursServices = new JoueursServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, List<JoueursDto>> allJoueursH = (Map<String, List<JoueursDto>>) joueursServices.getListeJoueurs('H');
        Map<String, List<JoueursDto>> allJoueursF = (Map<String, List<JoueursDto>>) joueursServices.getListeJoueurs('F');
        req.setAttribute("listeHommes", allJoueursH.get("hommes"));
        req.setAttribute("listeFemmes", allJoueursF.get("femmes"));

        RequestDispatcher disp = req.getRequestDispatcher("liste.jsp");
        disp.forward(req, resp);
    }

}
