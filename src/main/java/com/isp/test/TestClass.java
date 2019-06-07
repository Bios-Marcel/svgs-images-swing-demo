/**
 * © 2017 isp-insoft GmbH
 */
package com.isp.test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author msc
 * @since 08.12.2017
 *
 */
public class TestClass
{
  public static void main( final String[] args )
  {
    final JFrame demo = new JFrame( "Demo Icon Resolution" );

    final JButton button = new JButton( "Test", new ImageIcon( SVGIcons.PLUS.get( 128.8f, 128.8f ) ) );
    demo.getContentPane().add( button );
    demo.setSize( 800, 600 );
    demo.setVisible( true );
  }
}

