package com.skrymer.qrbuilder;

import com.skrymer.qrbuilder.decorator.QRCodeDecorator;
import com.skrymer.qrbuilder.exception.CouldNotCreateQRCodeException;
import com.skrymer.qrbuilder.exception.UnreadableDataException;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: skrymer
 * Date: 21/04/13
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface QRCBuilder {

  /**
   * Syntactic sugar - qrbuilder.newQRCode().with....
   * @return
   */
  public QRCBuilder newQRCode();

  /**
   * Syntactic sugar - qrbuilder.newQRCode().with().and().with()
   * @return
   */
  public QRCBuilder and();

  /**
   * Should the generated QRCode be verified after creation
   *
   * @param doVerify
   * @return
   */
  public QRCBuilder verifyQRCode(Boolean doVerify);

  /**
   * Adds the specified data to the QRCode
   *
   * @param data
   * @return
   */
  public QRCBuilder withData(String data);

  /**
   * Sets the size for the generated QRCode
   * @param width
   * @param height
   * @throws com.skrymer.qrbuilder.exception.InvalidSizeException
   *    If width or height <= 0 a InvalidSizeException is thrown
   * @return
   *    this
   */
  public QRCBuilder withSize(Integer width, Integer height);

  /**
   * Adds the given decorator. Decoration is applied after the qrcode has been generated
   *
   * If more than one decorator is added, the order on which they are called will be FIFO style
   *
   * @param decorator
   * @return
   */
  public QRCBuilder decorate(QRCodeDecorator decorator);

  /**
   * Creates the new QRCode image with the specified attributes
   *
   * @throws com.skrymer.qrbuilder.exception.CouldNotCreateQRCodeException
   *    If the QRCode could not be generated a CouldNotCreateQRCodeException is thrown
   * @throws com.skrymer.qrbuilder.exception.UnreadableDataException
   *    If the data contained in the QRCode is not the same as the data specified or the data is unreadable
   * @return
   *    The new QRCode image
   */
  public BufferedImage create() throws CouldNotCreateQRCodeException, UnreadableDataException;
}