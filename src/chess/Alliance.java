package chess;

import chess.player.BlackPlayer;
import chess.player.Player;
import chess.player.WhitePlayer;

public enum Alliance {
    WHITE {
        @Override
        public int getDirection(){
            return -1;
        }
        @Override
        public boolean isWhite(){
            return true;
        }
        @Override
        public boolean isBlack(){
            return false;
        }

        @Override
        public Player choosePlayer(final WhitePlayer whitePlayer,
                                   final BlackPlayer blackPlayer) {
            return blackPlayer;
        }
    },
    BLACK {
        @Override
        public int getDirection(){
            return 1;
        }
        @Override
        public boolean isWhite(){
            return false;
        }
        @Override
        public boolean isBlack(){
            return true;
        }

        @Override
        public Player choosePlayer(final WhitePlayer whitePlayer,
                                   final BlackPlayer blackPlayer) {
            return whitePlayer;
        }
    };

    public abstract int getDirection();
    public abstract boolean isWhite();
    public abstract boolean isBlack();

    public abstract Player choosePlayer(WhitePlayer whitePlayer, BlackPlayer blackPlayer);
}
