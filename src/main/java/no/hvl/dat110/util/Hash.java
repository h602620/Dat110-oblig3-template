
package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger


		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(entity.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashintString = no.toString(16);
			while (hashintString.length() < 32) {
				hashintString = "0" + hashintString;
			}
			hashint = new BigInteger(hashintString, 16);
			return hashint;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}


	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size

		int MD5Len = bitSize();
		BigInteger addressSpace = BigInteger.valueOf(2).pow(MD5Len);
		return addressSpace;

	}
	
	public static int bitSize() {
		
	int digestlen = 0;


		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			digestlen = md.getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return digestlen * 8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
