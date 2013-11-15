package com.change.java.test;

/**
 * User: changejava
 * Date: 13-8-19
 * Time: 上午1:51
 */
public class SpaceShipControls {
    void up(int velocity) {
    }


    public class SpaceShip {

        private final SpaceShipControls spaceShipControls = new SpaceShipControls();

        void up(int velocity) {
            spaceShipControls.up(velocity);
        }
    }
}
