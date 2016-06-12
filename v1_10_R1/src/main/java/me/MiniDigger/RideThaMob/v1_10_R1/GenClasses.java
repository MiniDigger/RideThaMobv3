package me.MiniDigger.RideThaMob.v1_10_R1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GenClasses {

    private static final File f = new File( "v1_10_R1/src/main/java/me/MiniDigger/RideThaMob/v1_10_R1/entities" );
    private static final File orig = new File( new File( "v1_10_R1/src/main/java/me/MiniDigger/RideThaMob/v1_10_R1" ), "RideAbleEntity.java" );

    public static void main( final String[] args ) throws IOException {
        System.out.println( f.getAbsolutePath() );
        for ( final File d : f.listFiles() ) {
            if ( d.getName().startsWith( "RideAble" ) ) {
                if ( !d.getName().contains( "Entity" ) ) {
                    try {
                        System.out.println( "do stuff " + d.getName() );
                        doStuff( d );
                    } catch ( final Exception e ) {
                        System.out.println( "error " + e.getMessage() );
                        continue;
                    }
                }
            }
        }
    }

    private static void doStuff( final File file ) throws FileNotFoundException {
        final Scanner s = new Scanner( orig );
        final PrintWriter w = new PrintWriter( file );

        while ( s.hasNextLine() ) {
            w.println( s.nextLine().replace( "EntitySkeleton", "Entity" + file.getName().replace( ".java", "" ).replace( "RideAble", "" ) )
                    .replace( "RideAbleEntity", file.getName().replace( ".java", "" ) ).replace( "%date%", new SimpleDateFormat().format( new Date() ) ).
                            replace( "package me.MiniDigger.RideThaMob.v1_10_R1;", "package me.MiniDigger.RideThaMob.v1_10_R1.entities;" ) );
        }

        w.close();
        s.close();
    }
}
