(ns rna-transcription (:require [clojure.string :as string]))

(def convert
  {"C" "G"
   "G" "C"
   "T" "A"
   "A" "U"})

(defn to-rna [dna] ;; <- arglist goes here
  ;; your code goes here
  (assert (re-find #"^[GACT]+$" dna) (throw (AssertionError. "Wrong input.")))
  (->>
   (string/split dna #"")
   (map convert)
   (string/join)))