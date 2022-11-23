(ns annalyns-infiltration)

(defn can-fast-attack?
  "Returns true if a fast-attack can be made, false otherwise."
  [knight-awake?]
  (not knight-awake?))

(defn can-spy?
  "Returns true if the kidnappers can be spied upon, false otherwise."
  [knight-awake? archer-awake? prisoner-awake?]
  (cond
    (= (or knight-awake? archer-awake? prisoner-awake?) true) true
    :else false))

(defn can-signal-prisoner?
  "Returns true if the prisoner can be signalled, false otherwise."
  [archer-awake? prisoner-awake?]
  (cond
    (= archer-awake? true) false
    (= prisoner-awake? true) true
    :else false))

(defn can-free-prisoner?
  "Returns true if prisoner can be freed, false otherwise."
  [knight-awake? archer-awake? prisoner-awake? dog-present?]
  (cond
    (= (and knight-awake? archer-awake?) true) false
    (= (and knight-awake? dog-present?) true) true
    (= archer-awake? true) false
    (= dog-present? true) true
    (= knight-awake? true) false
    (= prisoner-awake? true) true
    :else false))
