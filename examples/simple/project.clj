(defproject simple "0.9.0"
  :dependencies [[org.clojure/clojure        "1.8.0"]
                 [org.clojure/clojurescript  "1.9.227"]
                 [cljsjs/react "15.4.2-0"]
                 [cljsjs/react-dom "15.4.2-0"]
                 [reagent  "0.6.0-rc"]
                 [org.martinklepsch/derivatives "0.2.0"]
                 [rum "0.10.8"]

                 [com.chpill.re-frankenstein "0.0.1-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel  "0.5.4-7"]]

  :hooks [leiningen.cljsbuild]

  :profiles {:dev {:cljsbuild
                   {:builds {:client {:figwheel     {:on-jsload "simple.core/run"}
                                      :compiler     {:main "simple.core"
                                                     :asset-path "js"
                                                     :optimizations :none
                                                     :source-map true
                                                     :source-map-timestamp true}}}}}

             :prod {:cljsbuild
                    {:builds {:client {:compiler    {:optimizations :advanced
                                                     :elide-asserts true
                                                     :pretty-print false}}}}}}

  :figwheel {:repl false}

  :clean-targets ^{:protect false} ["resources/public/js"]

  :cljsbuild {:builds {:client {:source-paths ["src"]
                                :compiler     {:output-dir "resources/public/js"
                                               :output-to  "resources/public/js/client.js"}}}})
