package com.objects;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;

public class Procedures {
    public static final String PROJECTID = "cs4400p4";
    public static String toDate(String s) {
        return "cast(" + s + " as date format 'YYYY-MM-DD')";
    }
    public static String f(String A) {
        if (A == null) {
            return null;
        }
        String res = "'" + A + "'";
        return res;
    }
    public static void procedure1(String username, String firstName, String lastName, String address, String birthdate) {
        try {
            username = "'" + username + "'";
            firstName = "'" + firstName + "'";
            lastName = "'" + lastName + "'";
            address = "'" + address + "'";
            birthdate = "'" + birthdate + "'";

            String args = username + "," + firstName + "," + lastName + "," + address + "," + toDate(birthdate);

            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.add_owner`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure2(String username, String firstName, String lastName, 
    String address, String birthdate, String taxID, String hired, Integer experience, Integer salary) {

        try {
            username = f(username);
            firstName = f(firstName);
            lastName = f(lastName);
            address = f(address);
            birthdate = f(birthdate);
            taxID = f(taxID);
            hired = f(hired);
            String args = username + "," + firstName + "," + lastName + "," +
            address + "," + toDate(birthdate) + "," + taxID + "," + toDate(hired) + "," + experience + "," + salary;
            System.out.println(args);
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.add_employee`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure3(String username, String licenseID, String licenseType, Integer experience) {
        try {
            username = f(username);
            licenseID = f(licenseID);
            licenseType = f(licenseType);

            String args = username + "," + licenseID + "," + licenseType + "," + experience;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.add_driver_role`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure4(String username) {
        try {
            username = f(username);
            System.out.println(username);
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
            QueryJobConfiguration.newBuilder(
                "call `business_supply.add_worker_role`(" + username + ")"
            ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }


    public static void procedure5(String barcode, String name, Integer weight) {
        barcode = f(barcode);
        name = f(name);
        String args = barcode + "," + name + "," + weight;
        try {
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.add_product`("+ args +")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }


    public static void procedure6(String id, Integer tag, Integer fuel, Integer capacity, Integer sales, String drivenBy) {
        try {
            id = f(id);
            drivenBy = f(drivenBy);
            String args = id + "," + tag + "," + fuel + "," + capacity + "," + sales + "," + drivenBy;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.add_van`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }


    public static void procedure7(String longName, Integer rating, Integer spent, String location) {
        try {
            longName = f(longName);
            location = f(location);
            String args = longName + "," + rating + "," + spent + "," + location;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.add_business`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }


    public static void procedure8(String id, String longName, String homeBase, String manager) {
        try {
            id = f(id);
            longName = f(longName);
            homeBase = f(homeBase);
            manager = f(manager);
            String args = id + "," + longName + "," + homeBase + "," + manager;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.add_service`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }


    public static void procedure9(String label, Integer x, Integer y, Integer space) {
        try {
            if (Integer.compare(space, Integer.MAX_VALUE) == 0) {
                System.out.println("not valid");
                space = null;
            }

            label = f(label);
            String args = label + "," + x + "," + y + "," + space;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.add_location`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure11(String username, String id) {
        try {
            username = f(username);
            id = f(id);
            String args = username + "," + id;
            System.out.print("call `business_supply.hire_employee`(" + args + ")");
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.hire_employee`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure10(String owner, Integer amount, String longName, String fundDate) {
        try {
            owner = f(owner);
            longName = f(longName);
            fundDate = f(fundDate);
            String args = owner + "," + amount + "," + longName + "," + toDate(fundDate);
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.start_funding`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure12(String username, String id) {
        try {
            username = f(username);
            id = f(id);
            String args = username + "," + id;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.fire_employee`(" + args +")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure13(String username, String id) {
        try {
            username = f(username);
            id = f(id);
            String args = username + "," + id;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.manage_service`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure14(String username, String id, Integer tag) {
        try {
            username = f(username);
            id = f(id);
            String args = username + "," + id + "," + tag;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.takeover_van`(" + args +")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure15(String id, Integer tag, String barcode, Integer morePackages, Integer price) {
        try {
            id = f(id);
            barcode = f(barcode);
            String args = id + "," + tag + "," + barcode + "," + morePackages + "," + price;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.load_van`(" + args +")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure16(String id, Integer tag, Integer moreFuel) {
        try {
            id = f(id);
            String args = id + "," + tag + "," + moreFuel;
            System.out.println("call `business_supply.refuel_van`(" + args + ")");
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.refuel_van`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure17(String id, Integer tag, String destination) {
        try {
            id = f(id);
            destination = f(destination);
            String args = id + "," + tag + "," + destination;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.drive_van`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure18(String longName, String id, Integer tag, String barcode, Integer quantity) {
        try {
            longName = f(longName);
            id = f(id);
            barcode = f(barcode);
            String args = longName + "," + id + "," + tag + "," + barcode + "," + quantity;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.purchase_product`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure19(String barcode) {
        try {
            barcode = f(barcode);
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.remove_product`(" + barcode + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure20(String id, Integer tag) {
        try {
            id = f(id);
            String args = id + "," + tag;
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.remove_van`(" + args + ")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

    public static void procedure21(String username) {
        try {
            username = f(username);
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "call `business_supply.remove_driver_role`(" + username +")"
                ).setUseLegacySql(false).build();

            JobId jobId = JobId.newBuilder().setProject(PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }
        } catch (BigQueryException | InterruptedException e) {
        System.out.println("Simple App failed due to error: \n" + e.toString());
        }
    }

}