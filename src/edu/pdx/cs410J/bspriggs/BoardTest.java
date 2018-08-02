package edu.pdx.cs410J.bspriggs;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class BoardTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Board.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testCanConstruct(){
        var b = getBoard();
        assertThat(b, is(not(null)));
    }

    @Test
    public void testHasUnits() {
        var b = getBoard();

        assertThat(b.getUnits(), is(not(null)));
    }

    private Board getBoard() {
        return null;
    }
}
