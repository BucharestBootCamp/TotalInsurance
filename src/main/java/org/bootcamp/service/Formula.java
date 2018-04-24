package org.bootcamp.service;

import org.bootcamp.vehicle.Vehicle;

enum Formula {

    CAR_BASIC_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            int milesTax = vehicle.getNumberOfMiles() > 200000 ? 500 : 0;
            int dieselTax = vehicle.isDiesel() ? 500 : 0;

            return 100 * vehicle.getAge() + milesTax + dieselTax;
        }
    },

    CAR_CHRISTMAS_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            int milesTax = vehicle.getNumberOfMiles() > 200000 ? 500 : 0;
            int dieselTax = vehicle.isDiesel() ? 500 : 0;
            int discount = 50;

            return 100 * vehicle.getAge() + milesTax + dieselTax - 50;
        }
    },

    BUS_BASIC_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            return 11;
        }
    },

    BUS_CHRISTMAS_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            return 10;
        }
    },

    TIPPER_BASIC_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            return 11;
        }
    },

    TIPPER_CHRISTMAS_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            return 10;
        }
    };


    public abstract int calculate(Vehicle vehicle);
}
