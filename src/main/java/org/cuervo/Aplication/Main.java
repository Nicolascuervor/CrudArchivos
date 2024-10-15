package org.cuervo.Aplication;

import org.cuervo.Aplication.Services.RopaService;
import org.cuervo.Infrastructure.fileRopaRepository;
import org.cuervo.Interface.ropaRepository;

public class Main {
    public static void main(String[] args) {
        ropaRepository repo = new fileRopaRepository();
        RopaService servicio = new RopaService(repo);

        Menu m = new Menu(servicio);

        m.run();

    }
}
