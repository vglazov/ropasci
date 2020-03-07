package com.example;

public enum RoundResult {
    WIN, LOSE, TIE;

    public RoundResult inverse() {
        switch (this) {
            case TIE: return TIE;
            case WIN: return LOSE;
            case LOSE: return WIN;
        }

        throw new IllegalArgumentException();
    }
}
