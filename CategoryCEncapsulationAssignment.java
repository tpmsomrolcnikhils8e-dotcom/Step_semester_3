import java.util.Arrays;

public class CategoryCEncapsulationAssignment {

    // ==========================================
    // Problem 1: The Health Bar
    // ==========================================
    static class Character {
        private final int maxHealth;
        private int currentHealth;

        public Character(int maxHealth) {
            this.maxHealth = maxHealth;
            this.currentHealth = maxHealth;
        }

        public void takeDamage(int amount) {
            this.currentHealth -= amount;
            if (this.currentHealth < 0) {
                this.currentHealth = 0;
            }
            System.out.println("Took " + amount + " damage -> health = " + this.currentHealth);
        }

        public void heal(int amount) {
            this.currentHealth += amount;
            if (this.currentHealth > this.maxHealth) {
                this.currentHealth = this.maxHealth;
            }
            System.out.println("Healed " + amount + " -> health = " + this.currentHealth + " (Capped)");
        }

        public int getCurrentHealth() {
            return this.currentHealth;
        }

        public int getMaxHealth() {
            return this.maxHealth;
        }
    }

    // ==========================================
    // Problem 2: The Playlist
    // ==========================================
    static class Playlist {
        private final String[] songs;
        private int count;

        public Playlist(int maxSongs) {
            this.songs = new String[maxSongs];
            this.count = 0;
        }

        public void addSong(String songTitle) {
            if (count < songs.length) {
                songs[count] = songTitle;
                count++;
                System.out.println("Added: " + songTitle);
            } else {
                System.out.println("Playlist full! Cannot add " + songTitle);
            }
        }

        public String[] getSongs() {
            // Return a safe copy of only added elements
            return Arrays.copyOf(songs, count);
        }

        public int getSongCount() {
            return this.count;
        }
    }

    // ==========================================
    // Problem 3: The Password Checker
    // ==========================================
    static class PasswordChecker {
        private final String password;

        public PasswordChecker(String password) {
            this.password = password;
        }

        public String getStrength() {
            int len = password.length();
            if (len < 6) {
                return "Weak";
            } else if (len <= 9) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    // ==========================================
    // Problem 4: The Traffic Light
    // ==========================================
    static class TrafficLight {
        private final String lightId;
        private String color;

        public TrafficLight(String lightId) {
            this.lightId = lightId;
            this.color = "RED";
        }

        public void next() {
            switch (color) {
                case "RED":
                    color = "GREEN";
                    break;
                case "GREEN":
                    color = "YELLOW";
                    break;
                case "YELLOW":
                    color = "RED";
                    break;
            }
            System.out.println("Light changed -> " + color);
        }

        public String getColor() {
            return this.color;
        }

        public String getLightId() {
            return this.lightId;
        }
    }

    // ==========================================
    // Problem 5: The Shopping Cart
    // ==========================================
    static class Cart {
        private final String cartId;
        private final double[] prices;
        private int itemCount;

        public Cart(String cartId, int maxItems) {
            this.cartId = cartId;
            this.prices = new double[maxItems];
            this.itemCount = 0;
        }

        public void addItem(double price) {
            if (itemCount < prices.length) {
                prices[itemCount] = price;
                itemCount++;
                System.out.println("Added item price: " + price);
            } else {
                System.out.println("Cart is full!");
            }
        }

        public double getTotal() {
            double total = 0.0;
            for (int i = 0; i < itemCount; i++) {
                total += prices[i];
            }
            return total;
        }

        public int getItemCount() {
            return this.itemCount;
        }

        public String getCartId() {
            return this.cartId;
        }
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Health Bar ===");
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);

        System.out.println("\n=== Problem 2: The Playlist ===");
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Original Playlist index 0 is still: " + p.getSongs()[0]);
        System.out.println("Playlist count: " + p.getSongCount());

        System.out.println("\n=== Problem 3: The Password Checker ===");
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc1.getStrength() -> " + pc1.getStrength());
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("pc2.getStrength() -> " + pc2.getStrength());

        System.out.println("\n=== Problem 4: The Traffic Light ===");
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Initial color: " + t.getColor());
        t.next();
        t.next();
        t.next();

        System.out.println("\n=== Problem 5: The Shopping Cart ===");
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
