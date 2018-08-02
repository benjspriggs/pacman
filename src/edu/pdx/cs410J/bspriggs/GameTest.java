package edu.pdx.cs410J.bspriggs;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Arquillian.class)
public class GameTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Game.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testIsInitialized() {
        var g = new Game();
        assertThat(g.done(), is(true));
    }

    @Test
    public void testIsInitializedWithABoard() {
        var board = getBoard();
        var g = new Game(board);
        assertThat(g.board(), equalTo(board));
    }

    @Test
    public void testCanGetNextBoard() {
        var board = getBoard();
        var g = new Game(board);
        var nextBoard = g.nextBoard();

        assertThat(nextBoard, is(not(null)));
    }

    private Board getBoard() {
        return new Board();
    }
}
