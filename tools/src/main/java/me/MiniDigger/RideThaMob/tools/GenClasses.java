package me.MiniDigger.RideThaMob.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GenClasses {

    public static final String[] supportedVersions = { "v1_8_R3", "v1_9_R1", "v1_9_R2", "v1_10_R1" };

    public static void main( final String[] args ) throws IOException {
        for ( String version : supportedVersions ) {
            File f = new File( version + "/src/main/java/me/MiniDigger/RideThaMob/" + version + "/entities" );
            File orig = new File( f.getParent(), "RideAbleEntity.java" );

            System.out.println( "=========================================" );
            System.out.println( version + ": " + f.getAbsolutePath() );
            File[] files = f.listFiles();
            if ( files == null ) {
                System.out.println( "Its null!" );
                continue;
            }
            for ( final File d : files ) {
                if ( d.getName().startsWith( "RideAble" ) ) {
                    if ( !d.getName().contains( "Entity" ) ) {
                        try {
                            System.out.println( "do stuff " + d.getName() );
                            doStuff( d, orig, version );
                        } catch ( final Exception e ) {
                            System.out.println( "error " + e.getMessage() );
                            continue;
                        }
                    }
                }
            }
            System.out.println( "=========================================" );
        }
    }

    private static void doStuff( final File file, final File orig, final String version ) throws FileNotFoundException {
        final Scanner s = new Scanner( orig );
        final PrintWriter w = new PrintWriter( file );

        while ( s.hasNextLine() ) {
            w.println( s.nextLine().replace( "EntitySkeleton", "Entity" + file.getName().replace( ".java", "" ).replace( "RideAble", "" ) )
                    .replace( "RideAbleEntity", file.getName().replace( ".java", "" ) ).replace( "%date%", new SimpleDateFormat().format( new Date() ) ).
                            replace( "package me.MiniDigger.RideThaMob." + version + ";", "package me.MiniDigger.RideThaMob." + version + ".entities;" ) );
        }

        w.close();
        s.close();
    }
}
