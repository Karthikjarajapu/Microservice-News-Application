package com.wipro.mvc.security;

public class SHA256 {
    public static void main(String[] args) {
        // Example usage of SHA256 class
        String inputString = "Hello, World!";
        byte[] key = inputString.getBytes();

        byte[] hash = SHA256.getHash(key);

        System.out.println("SHA-256 hash of '" + inputString + "': " + bytesToHex(hash));
    }

    private static byte[] getHash(byte[] key) {
		// TODO Auto-generated method stub
		return null;
	}

	// Utility method to convert byte array to hex string for printing
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
