(defproject de.sveri/closp-crud "0.1.6-Snapshot"
  :description "CRUD plugin for closp: https://github.com/sveri/closp"
  :url "https://github.com/sveri/closp-crud"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clj-liquibase "0.5.2"]
                 [clj-jdbcutil "0.1.0"]
                 [clj-dbcp "0.8.1"]
                 [org.clojure/tools.cli "0.3.1"]
                 [de.sveri/clojure-commons "0.2.0"]
                 [clj-time "0.9.0"]
                 [selmer "0.8.2"]
                 [hiccup "1.0.5"]

                 ;; Microsoft SQL Server using the jTDS driver
                 [net.sourceforge.jtds/jtds "1.2.4"]
                 ;; MySQL
                 [mysql/mysql-connector-java "5.1.25"]
                 ;; PostgreSQL
                 [postgresql/postgresql "8.4-702.jdbc4"]
                 ;; SQLite
                 [org.xerial/sqlite-jdbc "3.8.7"]
                 ;; H2
                 [com.h2database/h2 "1.4.185"]]
  :main ^:skip-aot closp-crud-lib.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:resource-paths ["test-resources"]}}
  :deploy-repositories [["clojars-self" {:url           "https://clojars.org/repo"
                                         :sign-releases false}]])
