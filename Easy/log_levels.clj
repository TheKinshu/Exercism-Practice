(ns log-levels
  (:require [clojure.string :as str]))


(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (clojure.string/join " " (rest (str/split s #"\s+"))))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (let [re (rest (re-matches #"\[([A-Z]+)]:\s*([\w ]+)\s*" s))]
    (str/lower-case (first re))))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [level (log-level s)
        desc (message s)]
    (clojure.string/join (str desc " (" level ")"))))
