/**
 * © 2017 isp-insoft GmbH
 */
package com.isp.test;

import java.awt.image.BufferedImage;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.transcoder.SVGAbstractTranscoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.TranscodingHints;
import org.apache.batik.transcoder.XMLAbstractTranscoder;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.util.SVGConstants;

/**
 * @author msc
 * @since 08.12.2017
 */
public enum SVGIcons
{
  TEST( "/test.svg" ),
  PLUS( "/plus.svg" ),
  ICON( "/icon.svg" );

  private String path;

  SVGIcons( final String path )
  {
    this.path = path;
  }

  public BufferedImage get( final float width, final float height )
  {
    final MyTranscoder transcoder = new MyTranscoder();
    final TranscodingHints hints = new TranscodingHints();
    hints.put( SVGAbstractTranscoder.KEY_WIDTH, width );
    hints.put( SVGAbstractTranscoder.KEY_HEIGHT, height );
    hints.put( XMLAbstractTranscoder.KEY_DOM_IMPLEMENTATION, SVGDOMImplementation.getDOMImplementation() );
    hints.put( XMLAbstractTranscoder.KEY_DOCUMENT_ELEMENT_NAMESPACE_URI, SVGConstants.SVG_NAMESPACE_URI );
    hints.put( XMLAbstractTranscoder.KEY_DOCUMENT_ELEMENT, SVGConstants.SVG_SVG_TAG );
    hints.put( XMLAbstractTranscoder.KEY_XML_PARSER_VALIDATING, false );
    transcoder.setTranscodingHints( hints );
    try
    {
      transcoder.transcode( new TranscoderInput( TestClass.class.getResource( path ).toExternalForm() ), null );
    }
    catch ( final TranscoderException e )
    {
      System.out.println( "Something went terribly wrong." );
      return null;
    }

    return transcoder.getImage();
  }


  private static class MyTranscoder extends ImageTranscoder
  {
    private BufferedImage image = null;

    @Override
    public BufferedImage createImage( final int w, final int h )
    {
      image = new BufferedImage( w, h, BufferedImage.TYPE_INT_ARGB );
      return image;
    }

    public BufferedImage getImage()
    {
      return image;
    }

    @Override
    public void writeImage( final BufferedImage arg0, final TranscoderOutput arg1 ) throws TranscoderException
    {
      // TODO(msc|08.12.2017): Methode muss noch implementiert werden!
    }
  }
}
