package ru.evendot.task1;

/**
 * Игрок
 */
public class Player {
    /**
     * Очки здоровья игрока
     */
    private Integer hp;

    public Player() {
        this.hp = 6;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }
}
