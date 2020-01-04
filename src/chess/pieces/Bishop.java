package chess.pieces;

import chess.Alliance;
import chess.board.Board;
import chess.board.BoardUtils;
import chess.board.Move;
import chess.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bishop extends Piece {
    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES = {-9, -7, 7, 9};

    Bishop(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {//foreach in python
            int candindateDestinationCoordinate = this.piecePosition;
            while (BoardUtils.isValidCandidate(candindateDestinationCoordinate)) {
                candindateDestinationCoordinate += candidateCoordinateOffset;
                if (BoardUtils.isValidCandidate(candindateDestinationCoordinate)) {
                    final Tile candidateDestinationTile = board.getTile(candindateDestinationCoordinate); // pobieram Tile na ktory chce isc
                    if(!candidateDestinationTile.isOccupied()){ // jesli nie occupied
                        legalMoves.add(new Move.MajorMove(board,this,candindateDestinationCoordinate));
                    } else {
                        final Piece pieceAtDest = candidateDestinationTile.getPiece();
                        final Alliance pieceAtDestAlliance = pieceAtDest.getPieceAlliance();

                        if (this.pieceAlliance != pieceAtDestAlliance){
                            legalMoves.add(new Move.AttackMove(board,this, candindateDestinationCoordinate, pieceAtDest);
                        }
                    }
                    break; // to elimnate Tile ktore sa zasloniete przez te ktore sa occupied
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
    private static boolean isFirstColumn(final int currentPossition, )
}