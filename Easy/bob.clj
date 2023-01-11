(ns bob (:require [clojure.string :as string]))

(defn blank? [s]
  (string/blank? (string/trim s)))

(defn uppercase? [s]
  (if (string/blank? (re-find #"[a-zA-Z]&*" s)) false
      (= (string/upper-case s) s)))

(defn question? [s]
  (string/ends-with? (string/trim s) "?"))

(defn shout-question? [s]
  (if (blank? (re-find #"[a-zA-Z]*" s)) false
      (and (uppercase? s) (question? s))))

(defn response-for [s] ;; <- arglist goes here
  ;; your code goes here
  (cond
    (shout-question? s) "Calm down, I know what I'm doing!"
    (question? s) "Sure."
    (blank? s) "Fine. Be that way!"
    (uppercase? s) "Whoa, chill out!"
    :else "Whatever."))