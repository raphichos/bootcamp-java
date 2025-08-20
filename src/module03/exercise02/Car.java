package module03.exercise02;

public class Car {

    private boolean on;

    private int speed;

    private int gear;

    private int direction;

    public Car() {
        on = false;
        speed = 0;
        gear = 0;
    }

    public boolean isOn() {
        return this.on;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getGear() {
        return this.gear;
    }

    public void turnOn() {
        if (on) {
            System.out.println("Carro já está ligado");
        } else {
            on = true;
            System.out.println("Carro foi ligado");
        }
    }

    public void turnOff() {
        if (gear == 0 && speed == 0) {
            on = false;
            System.out.println("Carro foi desligado");
        } else {
            System.out.println("Carro tem que estar parado e no ponto morto");
        }
    }

    public boolean requireOn() {
        if (on) {
            return true;
        } else {
            System.out.println("Carro desligado. Ligue o carro primeiro");
            return false;
        }
    }

    public void accelerate() {
        if (!requireOn()) return;
        if (gear == 0) {
            System.out.println("Não é possível acelerar em ponto morto");
            return;
        }
        if (speed < getMaxSpeedForGear(gear)){
            speed++;
        } else {
            System.out.println("Limite desta marcha atingido (máx: " + getMaxSpeedForGear(gear) + " km/h). Troque de marcha para continuar");
        }
    }

    public void decelerate() {
        if (!requireOn()) return;
        if (speed == 0) {
            System.out.println("Carro está parado");
            return;
        }
        if (speed > getMinSpeedForGear(gear)){
            speed--;
        } else {
            System.out.println("Velocidade mínima para a marcha " + gear + " é " + getMinSpeedForGear(gear) + " km/h. Reduza a marcha para desacelerar mais");
        }
    }

    private int getMaxSpeedForGear(int gear) {
        return switch(gear) {
            case 0 -> 0;
            case 1 -> 20;
            case 2 -> 40;
            case 3 -> 60;
            case 4 -> 80;
            case 5 -> 100;
            case 6 -> 120;
            default -> throw new IllegalStateException("Invalid gear: " + gear);
        };
    }

    private int getMinSpeedForGear(int gear) {
        return switch(gear) {
            case 0, 1 -> 0;
            case 2 -> 21;
            case 3 -> 41;
            case 4 -> 61;
            case 5 -> 81;
            case 6 -> 101;
            default -> throw new IllegalStateException("Invalid gear: " + gear);
        };
    }

    public void shiftUp() {
        if (!requireOn()) return;
        if (gear == 6) {
            System.out.println("Já está na 6ª marcha");
            return;
        }
        int target = gear + 1;
        int min = getMinSpeedForGear(target);
        int max = getMaxSpeedForGear(target);
        if (speed >= min && speed <= max) {
            gear = target;
            System.out.println("Marcha aumentada para " + target);
        } else {
            System.out.println("Velocidade atual " + speed + " km/h incompatível com a marcha " + target + " (permitido: " + min + "-" + max + " km/h).");
        }
    }

    public void shiftDown() {
        if (!requireOn()) return;
        if (gear == 0) {
            System.out.println("Já está em ponto morto");
            return;
        }
        int target = gear - 1;
        int min = getMinSpeedForGear(target);
        int max = getMaxSpeedForGear(target);
        if (speed >= min && speed <= max) {
            gear = target;
            System.out.println("Marcha reduzida para " + target);
        } else {
            System.out.println("Velocidade atual " + speed + " km/h incompatível com a marcha " + target + " (permitido: " + min + "-" + max + " km/h).");
        }
    }

    private String getDirectionName() {
        return switch(direction) {
            case 0 -> "Norte";
            case 1 -> "Leste";
            case 2 -> "Sul";
            case 3 -> "Oeste";
            default -> "??";
        };
    }

    public void turnRight() {
        if (!requireOn()) return;
        if (speed < 1 || speed > 40) {
            System.out.println("Só pode virar entre 1 e 40 km/h (atual: " + speed + ")");
            return;
        } else {
            direction = (direction + 1) % 4;
            System.out.println("Virou à direita. Agora está indo para " + getDirectionName());
        }
    }

    public void turnLeft() {
        if (!requireOn()) return;
        if (speed < 1 || speed > 40) {
            System.out.println("Só pode virar entre 1 e 40 km/h (atual: " + speed + ")");
            return;
        } else {
            direction = (direction + 3) % 4;
            System.out.println("Virou à esquerda. Agora está indo para " + getDirectionName());
        }
    }

}
