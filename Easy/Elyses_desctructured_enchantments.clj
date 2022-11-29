(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[first-c] deck]
    first-c))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ second_c] deck]
    second_c))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[first-c second-c & rest-c] deck]
    (vec (conj rest-c first-c second-c))))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (let [top-card (first deck)
        rest-deck (rest deck)]
    [top-card
     (if (empty? rest-deck) nil (vec rest-deck))]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [top-card (if (empty? deck) face-cards (into [(first deck)] face-cards))
        rest-deck (vec (rest deck))]
    (into top-card rest-deck)))